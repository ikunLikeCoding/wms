<template>
  <!-- 采购列表 -->
  <div>
    <el-form inline class="searchForm">
      <el-form-item>
        <el-select v-model="params.storeId" style="width: 120px;" clearable>
          <el-option v-for="store of storeList" :label="store.storeName" :value="store.storeId" :key="store.storeId"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="开始时间:">
        <el-input type="date" v-model="params.startTime" style="width: 120px;"  clearable></el-input>
      </el-form-item>
      <el-form-item label="结束时间:">
        <el-input type="date" v-model="params.endTime" style="width: 120px;"  clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-input v-model="params.productName" placeholder="商品名称" style="width: 120px;"  clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-input v-model="params.buyUser" placeholder="采购人" style="width: 120px;"  clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-select v-model="params.isIn" style="width: 130px;" clearable>
          <el-option label="未入库" :value="0"></el-option>
          <el-option label="已入库" :value="1"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="getPurchasePageList">
          <el-icon>
            <svg t="1646977561352" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="3057" width="200" height="200"><path d="M986.304 871.424L747.328 630.4c-2.816-2.752-5.888-4.928-8.768-7.232 40.32-62.464 63.936-136.832 63.936-216.96 0-220.16-176.96-398.592-395.392-398.592C188.8 7.616 11.712 186.048 11.712 406.208s177.088 398.592 395.392 398.592a391.232 391.232 0 0 0 215.36-64.576c2.24 3.072 4.352 6.08 7.04 8.832l239.04 241.024a82.688 82.688 0 0 0 117.76 0 84.48 84.48 0 0 0 0-118.656m-579.2-192.512c-149.12 0-270.528-122.368-270.528-272.704 0-150.4 121.344-272.768 270.528-272.768 149.12 0 270.528 122.432 270.528 272.768 0 150.4-121.408 272.704-270.528 272.704" p-id="3058"></path></svg>
          </el-icon>
          &nbsp;查&nbsp;&nbsp;询
        </el-button>
      </el-form-item>
    </el-form>

  </div>

  <!-- 表格 -->
  <el-table :data="purchasePageList" style="width: 100%;margin-top: 10px;" table-layout="auto" size="large" border stripe>
    <el-table-column type="index" width="50" />
    <el-table-column prop="storeName" label="仓库名" sortable />
    <el-table-column prop="productName" label="商品名" sortable />
    <el-table-column prop="buyNum" label="预计采购数量" sortable />
    <el-table-column prop="factBuyNum" label="实际采购数量" sortable />
    <el-table-column prop="buyUser" label="采购人" sortable />
    <el-table-column prop="buyTime" label="采购时间" sortable />
    <el-table-column prop="phone" label="采购人电话" sortable />
    <el-table-column label="入库状态" sortable>
      <template #default="props">
          <span :class="{red:props.row.isIn==0, green: props.row.isIn==1}">{{props.row.isIn==0?"未入库":"已入库"}}</span>
      </template>
    </el-table-column>
    <el-table-column label="操作">
      <template #default="props">
        <el-button v-permission="'update-order'" v-if="!props.row.factBuyNum || props.row.factBuyNum==0" type="primary" title="修改采购单" :icon="Edit" circle @click="openPurchaseUpdate(props.row)" />
        <el-button v-permission="'delete-order'" v-if="!props.row.factBuyNum || props.row.factBuyNum==0" type="danger" title="删除采购单" :icon="Delete" circle @click="deletePurchase(props.row.buyId)" />
        <el-button v-permission="'update-order'" v-if="props.row.isIn==0 && props.row.factBuyNum>0" type="primary" @click="instore(props.row)">生成入库单</el-button>
      </template>
    </el-table-column>
  </el-table>
  <!-- 分页 -->
  <el-pagination
    background
    :total="params.total"
    :page-sizes="[5, 10, 15, 20, 25, 30]"
    v-model:page-size="params.pageSize"
    v-model:currentPage="params.currentPage"
    layout="total, sizes, prev, pager, next, jumper"
    style="margin-top: 20px;"
    @size-change="changeSize"
    @current-change="changeCurrent"
  />
  <!-- 修改采购单对话框 -->
  <purchase-update ref="purchaseUpdateRef" @ok="getPurchasePageList"></purchase-update>

</template>

<script setup>
import { reactive, ref } from 'vue';
import { useRoute, useRouter } from 'vue-router'
import { get, post, del, tip } from "@/common";
import { Search, Edit, Check, Message, Star, Delete } from '@element-plus/icons-vue'

const route = useRoute(); // 获取路由信息

// 分页模糊查询数据
const params = reactive({
  storeId: 1,
  startTime: '',
  endTime: '',
  productName: '',
  buyUser: '',
  isIn: '',
  pageSize: 5,
  currentPage: 1,
  total: 0
})

// 表格数据
const purchasePageList = ref();

// 获取分页模糊查询结果
const getPurchasePageList = () => {
  // 如果从添加采购单跳过来，会传参storeId
  if(route.query.storeId){
    params.storeId = parseInt(route.query.storeId);
  }
  // 后台获取查询结果
  get("/purchase/purchase-page-list", params).then(result => {
    purchasePageList.value = result.data.list;
    params.total = result.data.total;
  });
}
getPurchasePageList();

// 所有仓库
const storeList = ref();
// 获取所有仓库
const getStoreList = () => {
  get("/purchase/store-list").then(result => {
    storeList.value = result.data;
  });
}
getStoreList();



// 跳向修改采购单
import PurchaseUpdate from "./purchase-update.vue";
const purchaseUpdateRef = ref();
const openPurchaseUpdate = (purchase) => {
  purchaseUpdateRef.value.open(purchase);
};

// 删除采购单
const deletePurchase = (buyId) => {
  del(`/purchase/purchase-delete/${buyId}`, null, { title: "提示", message: "您确定删除该采购单吗？" }).then(result => {
    tip.success(result.message);
    getPurchasePageList();
  });
}

const router = useRouter(); // 获取路由器
// 生成入库单
const instore = (purchase) => {
  post('/purchase/in-warehouse-record-add', purchase).then(result => {
    tip.success(result.message);
    getPurchasePageList();
    // 入库成功，跳转到入库单列表页
    // router.push({path: '/instore/index', query: {'storeId': purchase.storeId}});
  });
}

// 修改每页显示条数
const changeSize = (size) => {
  params.pageSize = size;
  // 重新查询
  getPurchasePageList();
}
// 修改当前页码
const changeCurrent = (num) => {
  params.currentPage = num;
  // 重新查询
  getPurchasePageList();
}
</script>

<style scoped>
.searchForm{
  margin-top: 20px;
  display: flex;
}
.red{
  color: red;
}
.green{
  color: green;
}
</style>