<template>
  <!-- 添加供应商对话框 -->
  <el-dialog v-model="visible" title="添加供应商" width="400px" @close="close" destroy-on-close>
    <el-form ref="supplyAddRef" :model="supplyAdd" :rules="rules" label-position="top">
      <el-form-item label="供应商名称：" prop="supplyName">
        <el-input v-model="supplyAdd.supplyName" />
      </el-form-item>
      <el-form-item label="供应商编号：" prop="supplyNum">
        <el-input v-model="supplyAdd.supplyNum" />
      </el-form-item>
      <el-form-item label="供应商描述：" prop="introduce">
        <el-input v-model="supplyAdd.introduce" />
      </el-form-item>
    </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="close">取消</el-button>
        <el-button type="primary" @click="addsupply">确定</el-button>
      </span>
    </template>
  </el-dialog>
</template>

<script setup>
import { ref, reactive } from 'vue'
import { get, post, tip } from "@/common"
import { Plus } from '@element-plus/icons-vue'

// 该页面的可见性
const visible = ref(false);

// 添加供应商对象
const supplyAdd = reactive({
  supplyName: '',
  supplyNum: '',
  introduce: '',
});

// 验证供应商编号的唯一性
// 保留async+await用法
/* const validatesupplyNum = async(rule, supplyNum, callback) => {
  if (supplyNum === '') return callback(new Error('请输入供应商编号！'));
  const res = await get(`/supply/supply-num-verify?supplyNum=${supplyNum}`);
  if(!res.data) return callback(new Error('供应商编号已存在！'));
  return true;
} */

// 验证供应商编号的唯一性
const validatesupplyNum = (rule, supplyNum, callback) => {
  if(supplyNum==='') return callback(new Error('请输入供应商编号！'));
  get(`/supply/supply-num-verify?supplyNum=${supplyNum}`).then(res => {
    if(!res.data){
      callback(new Error('供应商编号已存在！'));
    }else{
      callback();
    }
  })
}

// 表单验证规则
const rules = reactive({
  supplyName: [
    { required: true, message: '请输入供应商名称', trigger: 'blur' }
  ],
  supplyNum: [
    { validator: validatesupplyNum, trigger: 'blur' }
  ]
})

// 关闭
const close = () => {
  for(let prop in supplyAdd){
    supplyAdd[prop] = '';
  }
  
  visible.value = false;
}

// 该对话框打开，进行数据初始化
const open = () => {
  visible.value = true;
};

const supplyAddRef = ref();
// 定义
const emit = defineEmits(["ok"]);
// 添加商品提交
const addsupply = () => {
  supplyAddRef.value.validate(valid => {
    if(valid){
      post('/supply/supply-add', supplyAdd).then(result => {
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