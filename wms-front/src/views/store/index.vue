<template>
  <!-- 仓库列表 -->
  <div>
    <el-form inline class="searchForm">
      <el-form-item>
        <el-input v-model="params.storeName" placeholder="仓库名称" style="width: 120px;"  clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-input v-model="params.storeAddress" placeholder="仓库地址" style="width: 120px;"  clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-input v-model="params.concat" placeholder="联系人" style="width: 120px;"  clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-input v-model="params.phone" placeholder="电话" style="width: 120px;"  clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="getStorePageList">
          <el-icon>
            <svg t="1657589745886" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="2261" width="200" height="200"><path d="M228.864 366.08h166.912v329.216c0 16.384 13.312 29.696 29.696 29.696h175.104c16.384 0 29.696-13.312 29.696-29.696V366.08h165.376c7.68 0 14.848-3.072 20.48-8.192 11.776-11.264 11.776-30.208 0.512-41.472l-283.136-286.72-1.024-1.024c-11.264-11.264-30.208-11.264-41.472 0.512l-283.136 286.72c-5.632 5.632-8.192 12.8-8.192 20.48 0 16.384 12.8 29.696 29.184 29.696z" p-id="2262" fill="#ffffff"></path><path d="M964.608 672.768c-32.768 0-59.392 26.624-59.392 59.392v152.064H119.296V732.16c0-32.768-26.624-59.392-59.392-59.392S0 699.392 0 732.16v211.968c0 32.768 26.624 59.392 59.392 59.392h904.704c32.768 0 59.392-26.624 59.392-59.392V732.16c0.512-32.768-26.112-59.392-58.88-59.392z" p-id="2263" fill="#ffffff"></path></svg>
          </el-icon>
          &nbsp;查&nbsp;&nbsp;询
        </el-button>
      </el-form-item>
    </el-form>
    <div>
      <el-button type="primary" @click="openStoreAdd()">
        <el-icon>
          <svg t="1646977404025" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="2197" width="200" height="200"><path d="M925.696 384q19.456 0 37.376 7.68t30.72 20.48 20.48 30.72 7.68 37.376q0 20.48-7.68 37.888t-20.48 30.208-30.72 20.48-37.376 7.68l-287.744 0 0 287.744q0 20.48-7.68 37.888t-20.48 30.208-30.72 20.48-37.376 7.68q-20.48 0-37.888-7.68t-30.208-20.48-20.48-30.208-7.68-37.888l0-287.744-287.744 0q-20.48 0-37.888-7.68t-30.208-20.48-20.48-30.208-7.68-37.888q0-19.456 7.68-37.376t20.48-30.72 30.208-20.48 37.888-7.68l287.744 0 0-287.744q0-19.456 7.68-37.376t20.48-30.72 30.208-20.48 37.888-7.68q39.936 0 68.096 28.16t28.16 68.096l0 287.744 287.744 0z" p-id="2198"></path></svg>
        </el-icon>
        &nbsp;添加仓库
      </el-button>

    </div>
  </div>

  <!-- 表格 -->
  <el-table :data="storePageList" style="width: 100%; margin-top: 10px;" table-layout="auto" size="large" border stripe>
    <el-table-column type="index" width="50" />
    <el-table-column prop="storeId" label="仓库ID" sortable />
    <el-table-column prop="storeName" label="仓库名称" sortable />
    <el-table-column prop="storeNum" label="仓库编号" sortable />
    <el-table-column prop="storeAddress" label="仓库地址" sortable />
    <el-table-column prop="concat" label="联系人" sortable />
    <el-table-column prop="phone" label="电话" sortable />
    <el-table-column label="操作">
      <template #default="props">
        <el-button type="primary" title="修改仓库" :icon="Edit" circle @click="openStoreUpdate(props.row)" />
        <el-button type="danger" title="删除仓库" :icon="Delete" circle @click="deleteStore(props.row.storeId)" />
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

  <!-- 添加仓库对话框 -->
  <store-add ref="storeAddRef" @ok="getStorePageList"></store-add>
  
  <!-- 修改仓库对话框 -->
  <store-update ref="storeUpdateRef" @ok="getStorePageList"></store-update>

</template>

<script setup>
import { reactive, ref } from 'vue';
import { get, put, del, tip } from "@/common";
import { useRouter } from "vue-router";
import { Search, Edit, Check, Message, Star, Delete } from '@element-plus/icons-vue'

const router = useRouter(); // 获取路由器

// 分页模糊查询数据
const params = reactive({
  storeName: '',
  storeAddress: '',
  concat: '',
  phone: '',
  pageSize: 5,
  pageNum: 1,
  totalNum: 0
})

// 表格数据
const storePageList = ref();

// 获取分页模糊查询结果
const getStorePageList = () => {
  get("/store/store-page-list", params).then(result => {
    storePageList.value = result.data.resultList;
    params.totalNum = result.data.totalNum;
  });
}
getStorePageList();


// 跳向添加仓库
import storeAdd from "./store-add.vue";
const storeAddRef = ref();
const openStoreAdd = () => {
  storeAddRef.value.open();
};


// 跳向修改仓库
import storeUpdate from "./store-update.vue";
const storeUpdateRef = ref();
const openStoreUpdate = (store) => {
  storeUpdateRef.value.open(store);
};


// 删除仓库
const deleteStore = (storeId) => {
  del(`/store/store-delete/${storeId}`, null, { title: "提示", message: "您确定删除该仓库吗？" }).then(result => {
    tip.success(result.message);
    // 重新查询
    getStorePageList();
  });
}

// 修改每页显示条数
const changeSize = (size) => {
  params.pageSize = size;
  // 重新查询
  getStorePageList();
}
// 修改当前页码
const changeCurrent = (num) => {
  params.pageNum = num;
  // 重新查询
  getStorePageList();
}
</script>

<style scoped>
.searchForm{
  margin-top: 20px;
  display: flex;
}
.el-link {
  margin-right: 8px;
}
</style>