<template>
  <!-- 添加角色对话框 -->
  <el-dialog v-model="visible" title="添加角色" width="25%" @close="close" destroy-on-close>
    <el-form ref="roleAddForm" :model="roleAdd" :rules="rules" label-position="top">
      <el-form-item label="名称：" prop="roleName">
        <el-input v-model="roleAdd.roleName" autocomplete="off" />
      </el-form-item>
      <el-form-item label="描述：" prop="roleDesc">
        <el-input v-model="roleAdd.roleDesc" autocomplete="off" />
      </el-form-item>
      <el-form-item label="代码：" prop="roleCode">
        <el-input v-model="roleAdd.roleCode" autocomplete="off" />
      </el-form-item>
    </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="close">取消</el-button>
        <el-button type="primary" @click="addRole">确定</el-button>
      </span>
    </template>
  </el-dialog>
</template>

<script setup>
import { ref, reactive } from 'vue'
import { post, tip } from "@/common";

const visible = ref(false); // 该页面的可见性
// 添加角色对象
const roleAdd = reactive({
  roleName: '',
  roleDesc: '',
  roleCode: '',
});

// 关闭
const close = () => {
  roleAdd.roleName = '';
  roleAdd.roleDesc = '';
  roleAdd.roleCode = '';
  visible.value = false;
}

// 验证角色编号的唯一性
const validateRoleCode = (rule, roleCode, callback) => {
  if(roleCode==='') callback(new Error('请输入角色编号！'));
  get(`/role/role-code-verify?roleCode=${roleCode}`).then(res => {
    if(!res.data){
      callback(new Error('角色编号已存在！'));
    }else{
      callback();
    }
  })
}

// 输入框内容的基本规则
const rules = reactive({
  roleName: [ { required: true, message: '请输入角色名', trigger: 'blur' } ],
  roleCode: [ { validator: validateRoleCode, trigger: 'blur' } ]
})

// 该对话框打开
const open = () => {
  visible.value = true;
};

const roleAddForm = ref();
// 定义
const emit = defineEmits(["ok"]);
// 添加角色提交
const addRole = () => {
  roleAddForm.value.validate(valid => {
    if(valid){
      post('/role/role-add', roleAdd).then(result => {
        emit('ok');
        tip.success(result.message);
        visible.value = false; // 关闭对话框
      });
    }
  });
}

// 将open方法暴露给父组件
defineExpose({ open });
</script>
<style scoped>

</style>