<template>
    <el-form inline>
      <el-form-item label="用户名:">
        <el-input v-model="params.userName" placeholder="用户名" style="width: 120px;"  clearable></el-input>
      </el-form-item>
      <el-form-item label="用户类型:" style="margin-left: 30px;">
        <el-select v-model="params.roleId" placeholder="用户类型" style="width: 120px;" clearable>
          <el-option v-for="role of roleList" :label="role.roleName" :value="role.roleId" :key="role.roleId"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="用户状态:" style="margin-left: 30px;">
        <el-select v-model="params.userState" placeholder="用户状态" style="width: 120px;" clearable>
          <el-option label="禁用" value="0"></el-option>
          <el-option label="启用" value="1"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item style="margin-left: 30px;">
        <el-button type="primary" @click="getUserList" style="margin-left: 10px;">
          <el-icon>
            <svg t="1646977561352" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="3057" width="200" height="200"><path d="M986.304 871.424L747.328 630.4c-2.816-2.752-5.888-4.928-8.768-7.232 40.32-62.464 63.936-136.832 63.936-216.96 0-220.16-176.96-398.592-395.392-398.592C188.8 7.616 11.712 186.048 11.712 406.208s177.088 398.592 395.392 398.592a391.232 391.232 0 0 0 215.36-64.576c2.24 3.072 4.352 6.08 7.04 8.832l239.04 241.024a82.688 82.688 0 0 0 117.76 0 84.48 84.48 0 0 0 0-118.656m-579.2-192.512c-149.12 0-270.528-122.368-270.528-272.704 0-150.4 121.344-272.768 270.528-272.768 149.12 0 270.528 122.432 270.528 272.768 0 150.4-121.408 272.704-270.528 272.704" p-id="3058"></path></svg>
          </el-icon>
          &nbsp;查&nbsp;&nbsp;询
        </el-button>
      </el-form-item>
    </el-form>

    <div>
      <el-button type="primary" @click="openUserAdd()">
        <el-icon>
          <svg t="1646977404025" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="2197" width="200" height="200"><path d="M925.696 384q19.456 0 37.376 7.68t30.72 20.48 20.48 30.72 7.68 37.376q0 20.48-7.68 37.888t-20.48 30.208-30.72 20.48-37.376 7.68l-287.744 0 0 287.744q0 20.48-7.68 37.888t-20.48 30.208-30.72 20.48-37.376 7.68q-20.48 0-37.888-7.68t-30.208-20.48-20.48-30.208-7.68-37.888l0-287.744-287.744 0q-20.48 0-37.888-7.68t-30.208-20.48-20.48-30.208-7.68-37.888q0-19.456 7.68-37.376t20.48-30.72 30.208-20.48 37.888-7.68l287.744 0 0-287.744q0-19.456 7.68-37.376t20.48-30.72 30.208-20.48 37.888-7.68q39.936 0 68.096 28.16t28.16 68.096l0 287.744 287.744 0z" p-id="2198"></path></svg>
        </el-icon>
        &nbsp;添加用户
      </el-button>

      <el-select placeholder="批量操作" style="width: 110px;margin-left: 12px; position: relative; top: 2px;">
        <el-option @click="deleteUserList">
          <span style="float: left;">
            <el-icon><delete /></el-icon>
          </span>
          <span style="padding-left: 6px; position: relative; top: -2px;">删除</span>
        </el-option>
      </el-select>
    </div>
    
    <!-- 表格 -->
    <el-table :data="userList" @selection-change="handleSelectionChange" style="width: 100%; margin-top: 10px;" table-layout="auto" size="large" border stripe>
      <el-table-column type="selection" width="55" />
      <el-table-column prop="userId" label="用户ID" sortable />
      <el-table-column prop="userCode" label="用户名" sortable />
      <el-table-column prop="userName" label="昵称" sortable />
      <el-table-column label="用户状态" sortable>
        <template #default="props">
            <span :class="{red:props.row.userState=='0'}">{{props.row.userState=="0"?"禁用":"启用"}}</span>
        </template>
      </el-table-column>
      <el-table-column prop="createByCode" label="创建人" sortable />
      <el-table-column prop="createTime" label="创建时间" sortable />
      <el-table-column label="操作">
        <template #default="props">
          <el-button type="primary" title="修改用户" :icon="Edit" circle @click="openUserUpdate(props.row)" />
          <el-button type="danger" title="删除用户" :icon="Delete" circle @click="deleteUser(props.row.userId)" />
          <el-button type="warning" @click="updateState(props.row)">{{props.row.userState=="1"?"禁用":"启用"}}</el-button>
          <el-button type="primary" v-if="props.row.userState==1" @click="resetPwd(props.row.userId)">重置密码</el-button>
          <el-button type="primary" v-if="props.row.userState==1" @click="openAssignRole(props.row)">分配角色</el-button>
          <el-button type="primary" v-if="props.row.userState==1" @click="openUpdateAuth(props.row)">更改权限</el-button>
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

    <!-- 添加用户对话框 -->
    <user-add ref="userAddRef" @ok="getUserList"></user-add>
    
    <!-- 修改用户对话框 -->
    <user-update ref="userUpdateRef" @ok="getUserList"></user-update>

    <!-- 分配角色对话框 -->
    <assign-role ref="assignRoleRef"></assign-role>
</template>

<script setup>
import { reactive, ref, computed } from 'vue';
import { useRouter } from 'vue-router'
import { get, put, del, tip } from "@/common";
import { Search, Edit, Check, Message, Star, Delete } from '@element-plus/icons-vue'

const router = useRouter(); // 获取路由器

// 分页模糊查询数据
const params = reactive({
  userName: '',
  roleId: '',
  userState: '',
  pageSize: 5,
  currentPage: 1,
  total: 0
})

// 表格数据
const userList = ref();

// 获取查询结果
const getUserList = () => {
  get("/user/user-page-list", params).then(result => {
    // console.log(result)
    userList.value = result.data.list;
    params.total = result.data.total;
  });
}
getUserList();

// 获取所有角色
const roleList = ref([]);
const getRoleList = () => {
  get("/role/role-list").then(result => {
    roleList.value = result.data;
  });
}
getRoleList();

// 选中的user列表
const multipleSelection = ref([]);
// 选中状态改变时的处理
const handleSelectionChange = (val) => {
  multipleSelection.value = val;
  console.log(multipleSelection.value);
}



// 删除用户提交
const deleteUser = (userId) => {
  del(`/user/user-delete/${userId}`, null, { title: "提示", message: "您确定删除该用户吗？" }).then(result => {
    tip.success(result.message);
    // 重新查询
    getUserList();
  });
}

// 批量删除
const deleteUserList = () => {
  if(multipleSelection.value.length){
    // 取出所有选中的id
    const userIds = multipleSelection.value.map(user => user.userId);
    /* const userIds = multipleSelection.value.reduce((prev, cur) =>{
      prev.push(cur.userId);
      return prev;
    }, []); */

    

    del('/user/user-list-delete', userIds, { title: "提示", message: "您确定删除选中用户吗？" }).then(result => {
      tip.success(result.message);
      // 重新查询
      getUserList();
    });
  }else{
    tip.error("请选择需要删除的行！");
  }
}

// 修改用户状态
const updateState = (user) => {
  user.userState = user.userState=="0"?"1":"0";
  put('/user/state-update', user).then(result => {
    // 重新查询
    getUserList();
  });
}

// 重置密码
const resetPwd = (userId) => {
  put(`/user/password-reset/${userId}`).then(result => {
    tip.success(result.msg);
    // 重新查询
    getUserList();
  });
}

// 添加用户
import UserAdd from "./user-add.vue";
const userAddRef = ref();
const openUserAdd = () => {
  userAddRef.value.open();
};

// 修改用户
import UserUpdate from "./user-update.vue";
const userUpdateRef = ref();
const openUserUpdate = (row) => {
  userUpdateRef.value.open(row);
};

// 分配角色
import AssignRole from "./assign-role.vue";
const assignRoleRef = ref();
const openAssignRole = (row) => {
  assignRoleRef.value.open(row, roleList);
};

// 点击修改权限
const openUpdateAuth = (user) => {
  // 通过路由导航到修改权限页面
  // path不可以和params搭档，否则params会失效
  // router.push({ name: 'authUpdate', params: {"userId": user.userId } });
  router.push({ path: '/user/auth-update', query: {"userId": user.userId } });
};

// 修改每页显示条数
const changeSize = (size) => {
  params.pageSize = size;
  // 重新查询
  getUserList();
}
// 修改当前页码
const changeCurrent = (num) => {
  params.currentPage = num;
  // 重新查询
  getUserList();
}

</script>
<style scoped>
.red{
  color: red;
}
</style>