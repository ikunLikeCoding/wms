<template>
  <!-- 添加用户对话框 -->
  <el-dialog v-model="visible" title="添加用户" width="25%" @close="close" destroy-on-close>
    <el-form ref="userAddForm" :model="userAdd" :rules="rules" label-position="top">
      <el-form-item label="用户名：" prop="userCode">
        <el-input v-model="userAdd.userCode" autocomplete="off" />
      </el-form-item>
      <el-form-item label="昵称：" prop="userName">
        <el-input v-model="userAdd.userName" autocomplete="off" />
      </el-form-item>
      <el-form-item label="密码：" prop="userPwd">
        <el-input type="password" show-password v-model="userAdd.userPwd" autocomplete="off" />
      </el-form-item>
      <el-form-item label="确认密码：" prop="confirmPassword">
        <el-input type="password" show-password v-model="userAdd.confirmPassword" autocomplete="off" />
      </el-form-item>
    </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="close">取消</el-button>
        <el-button type="primary" @click="addUser">确定</el-button>
      </span>
    </template>
  </el-dialog>
</template>

<script setup>
import { ref, reactive } from 'vue'
import { get, post, tip } from "@/common";

const visible = ref(false); // 该页面的可见性
// 添加用户对象
const userAdd = reactive({
  userCode: '',
  userName: '',
  userPwd: '',
  confirmPassword: ''
});

// 关闭
const close = () => {
  userAdd.userCode = '';
  userAdd.userName = '';
  userAdd.userPwd = '';
  userAdd.confirmPassword = '';
  visible.value = false;
}

// 验证用户编号的唯一性
const validateUserCode = (rule, userCode, callback) => {
  if(userCode==='') callback(new Error('请输入用户编号！'));
  get(`/user/user-code-verify?userCode=${userCode}`).then(res => {
    if(!res.data){
      callback(new Error('用户编号已存在！'));
    }else{
      // 这块的else分支必须加，保证所有结果res都有回调callback
      callback();
    }
  })
}

const rules = reactive({
  userCode: [{ validator: validateUserCode, trigger: 'blur' }],
  userPwd: [
    { required: true, message: '请输入密码', trigger: 'blur' },
    { min: 6, max: 20, message: '密码为6-20位', trigger: 'blur' }
  ],
  confirmPassword: [
    { required: true, message: '请再次输入密码', trigger: 'blur' },
    { min: 6, max: 20, message: '密码为6-20位', trigger: 'blur' }
  ]
})

// 该对话框打开
const open = () => {
  visible.value = true;
};

const userAddForm = ref();
// 定义
const emit = defineEmits(["ok"]);
// 添加用户提交
const addUser = () => {
  if(userAdd.userPwd!=userAdd.confirmPassword){
    tip.error("两次密码必须保持一致！");
    return;
  }
  userAddForm.value.validate(valid => {
    if(valid){
      post('/user/user-add', userAdd).then(result => {
        emit('ok');
        tip.success(result.message);
        visible.value = false; // 关闭对话框
      });
    }
  });
}

defineExpose({ open });
</script>
<style scoped>

</style>