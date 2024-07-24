<template>
  <!-- 分配角色对话框 -->
  <el-dialog v-model="visible" title="分配角色" width="25%">
    <el-form ref="userAssignRoleRef" :model="userAssignRole" label-position="top">
      <el-form-item label="用户名：">
        <el-input v-model="userAssignRole.userCode" autocomplete="off" disabled />
      </el-form-item>
      <el-form-item label="角色：">
        <!-- 功能：将用户已有角色默认选中 -->
        <!-- 方法一：v-model绑定boolean数组，true表示默认选中，false表示不选中 -->
        <!-- <el-checkbox v-for="role,idx of userAssignRole.roleList" v-model="chkList[idx]" :label="role.roleName" :key="role.roleId" /> -->
        <!-- 方法二：将lable属性需要默认选中的数据放入roleCheckList中 -->
        <el-checkbox-group v-model="userAssignRole.roleCheckList">
          <el-checkbox v-for="role of userAssignRole.roleList" :label="role.roleName" :key="role.roleId" />
        </el-checkbox-group>
      </el-form-item>
    </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="visible=false">取消</el-button>
        <el-button v-permission="'user-assignRole'" type="primary" @click="assignRole">确认修改</el-button>
      </span>
    </template>
  </el-dialog>
</template>

<script setup>
import { ref, reactive } from 'vue'
import { get, put, tip } from "@/common";

const visible = ref(false); // 该页面的可见性
const userRoleList = ref([]); // 用户的角色列表

// 分配角色对象
const userAssignRole = reactive({
  userId: '',
  userCode: '',
  roleList: [], // 角色列表
  roleCheckList: [] // 被选中的角色列表
});

// 该对话框打开并初始化
const open = (user, roleList) => {
  userAssignRole.userId = user.userId;
  userAssignRole.userCode = user.userCode;
  userAssignRole.roleList = roleList;
  visible.value = true;
  // 获取被分配角色用户的已有角色
  get(`/user/user-role-list/${user.userId}`).then(result => {
    userRoleList.value = result.data;
    checkedUserRole(); // 如果用户有该角色，则默认选中
  });
};

// const chkList = ref([]); // 分配角色时checkbox的boolean数组
// 默认选中用户已有角色
const checkedUserRole = () => {
  // 方法一：
  /* const roleIdAll = userAssignRole.roleList.map(role => role.roleId); // 所有roleId
  const roleIdUser = userRoleList.value.map(role => role.roleId); // 用户已有roleId
  roleIdAll.forEach(roleId => {
    chkList.value.push(roleIdUser.includes(roleId));
  }) */
  
  
  // 方法二：将用户已有的角色名放入roleCheckList
  // 1. forEach遍历
  // userRoleList.value.forEach(role => { userAssignRole.roleCheckList.push(role.roleName) });

  // 2. map映射
  userAssignRole.roleCheckList = userRoleList.value.map(role => role.roleName);

  // 3. reduce遍历
  /* userAssignRole.roleCheckList = userRoleList.value.reduce((pre, cur) => {
    pre.push(cur.roleName);
    return pre;
  }, []); */
}

const userAssignRoleRef = ref();
// 分配角色提交
const assignRole = () => {
  userAssignRoleRef.value.validate(valid => {
    if(valid){
      put('/user/role-assign', userAssignRole).then(result => {
        tip.success(result.msg);
        visible.value = false;
      });
    }
  });
}

defineExpose({ open });
</script>
<style scoped>

</style>