<template>
  <!-- 供应商列表 -->
  <div>
    <el-form inline class="searchForm">
      <el-form-item>
        <el-input v-model="params.supplyName" placeholder="供应商名称" style="width: 120px;"  clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-input v-model="params.supplyNum" placeholder="供应商编号" style="width: 120px;"  clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-input v-model="params.concat" placeholder="联系人" style="width: 120px;"  clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="getSupplyPageList">
          <el-icon>
            <svg t="1646977561352" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="3057" width="200" height="200"><path d="M986.304 871.424L747.328 630.4c-2.816-2.752-5.888-4.928-8.768-7.232 40.32-62.464 63.936-136.832 63.936-216.96 0-220.16-176.96-398.592-395.392-398.592C188.8 7.616 11.712 186.048 11.712 406.208s177.088 398.592 395.392 398.592a391.232 391.232 0 0 0 215.36-64.576c2.24 3.072 4.352 6.08 7.04 8.832l239.04 241.024a82.688 82.688 0 0 0 117.76 0 84.48 84.48 0 0 0 0-118.656m-579.2-192.512c-149.12 0-270.528-122.368-270.528-272.704 0-150.4 121.344-272.768 270.528-272.768 149.12 0 270.528 122.432 270.528 272.768 0 150.4-121.408 272.704-270.528 272.704" p-id="3058"></path></svg>
          </el-icon>
          &nbsp;查&nbsp;&nbsp;询
        </el-button>
      </el-form-item>
    </el-form>
    <div>
      <el-button type="primary" @click="openSupplyAdd()">
        <el-icon>
          <svg t="1646977404025" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="2197" width="200" height="200"><path d="M925.696 384q19.456 0 37.376 7.68t30.72 20.48 20.48 30.72 7.68 37.376q0 20.48-7.68 37.888t-20.48 30.208-30.72 20.48-37.376 7.68l-287.744 0 0 287.744q0 20.48-7.68 37.888t-20.48 30.208-30.72 20.48-37.376 7.68q-20.48 0-37.888-7.68t-30.208-20.48-20.48-30.208-7.68-37.888l0-287.744-287.744 0q-20.48 0-37.888-7.68t-30.208-20.48-20.48-30.208-7.68-37.888q0-19.456 7.68-37.376t20.48-30.72 30.208-20.48 37.888-7.68l287.744 0 0-287.744q0-19.456 7.68-37.376t20.48-30.72 30.208-20.48 37.888-7.68q39.936 0 68.096 28.16t28.16 68.096l0 287.744 287.744 0z" p-id="2198"></path></svg>
        </el-icon>
        &nbsp;添加供应商
      </el-button>

    </div>
  </div>

  <!-- 表格 -->
  <el-table :data="supplyPageList" style="width: 100%; margin-top: 10px;" table-layout="auto" size="large" border stripe>
    <el-table-column prop="supplyId" label="供应商ID" sortable />
    <el-table-column prop="supplyName" label="供应商名称" sortable />
    <el-table-column prop="supplyNum" label="供应商编号" sortable />
    <el-table-column prop="concat" label="联系人" />
    <el-table-column prop="phone" label="电话" />
    <el-table-column prop="address" label="地址" />
    <el-table-column label="操作">
      <template #default="props">
        <el-button type="primary" title="修改仓库" :icon="Edit" circle @click="openSupplyUpdate(props.row)" />
        <el-button type="danger" title="删除仓库" :icon="Delete" circle @click="deleteSupply(props.row.supplyId)" />
      </template>
    </el-table-column>
  </el-table>
  <!-- 分页 -->
  <el-pagination
    background
    :total="params.totalNum"
    :page-sizes="[5, 10, 15, 20, 25, 30]"
    v-model:page-size="params.pageSize"
    v-model:currentPage="params.pageNum"
    layout="total, sizes, prev, pager, next, jumper"
    style="margin-top: 20px;"
    @size-change="changeSize"
    @current-change="changeCurrent"
  />

  <!-- 添加供应商对话框 -->
  <supply-add ref="supplyAddRef" @ok="getSupplyPageList"></supply-add>
  
  <!-- 修改供应商对话框 -->
  <!-- <supply-update ref="supplyUpdateRef" @ok="getSupplyPageList"></supply-update> -->

</template>

<script setup>
import { reactive, ref } from 'vue';
import { get, put, del, tip } from "@/common";
import { useRouter } from "vue-router";
import { Search, Edit, Check, Message, Star, Delete } from '@element-plus/icons-vue'

const router = useRouter(); // 获取路由器

// 分页模糊查询数据
const params = reactive({
  supplyName: '',
  supplyNum: '',
  concat: '',
  pageSize: 5,
  pageNum: 1,
  totalNum: 0
})

// 表格数据
const supplyPageList = ref();

// 获取分页模糊查询结果
const getSupplyPageList = () => {
  get("/supply/supply-page-list", params).then(result => {
    supplyPageList.value = result.data.resultList;
    params.totalNum = result.data.totalNum;
  });
}
getSupplyPageList();




// 跳向添加供应商
import supplyAdd from "./supply-add.vue";
const supplyAddRef = ref();
const openSupplyAdd = () => {
  supplyAddRef.value.open();
};


// 跳向修改供应商
/* import supplyUpdate from "./supply-update.vue";
const supplyUpdateRef = ref();
const opensupplyUpdate = (supply) => {
  supplyUpdateRef.value.open(supply);
};
 */

// 删除供应商
const deleteSupply = (supplyId) => {
  del(`/supply/supply-delete/${supplyId}`, null, { title: "提示", message: "您确定删除该供应商吗？" }).then(result => {
    tip.success(result.message);
    // 重新查询
    getSupplyPageList();
  });
}

// 修改每页显示条数
const changeSize = (size) => {
  params.pageSize = size;
  // 重新查询
  getSupplyPageList();
}
// 修改当前页码
const changeCurrent = (num) => {
  params.pageNum = num;
  // 重新查询
  getSupplyPageList();
}
</script>

<style scoped>
.searchForm{
  margin-top: 20px;
  display: flex;
}
</style>