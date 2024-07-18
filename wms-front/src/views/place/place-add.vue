<template>
  <!-- 添加产地对话框 -->
  <el-dialog v-model="visible" title="添加产地" width="400px" @close="close" destroy-on-close>
    <el-form ref="placeAddRef" :model="placeAdd" :rules="rules" label-position="top">
      <el-form-item label="产地名称：" prop="placeName">
        <el-input v-model="placeAdd.placeName" />
      </el-form-item>
      <el-form-item label="产地编号：" prop="placeNum">
        <el-input v-model="placeAdd.placeNum" />
      </el-form-item>
      <el-form-item label="产地描述：" prop="introduce">
        <el-input v-model="placeAdd.introduce" />
      </el-form-item>
    </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="close">取消</el-button>
        <el-button type="primary" @click="addPlace">确定</el-button>
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

// 添加产地对象
const placeAdd = reactive({
  placeName: '',
  placeNum: '',
  introduce: '',
});

// 验证产地编号的唯一性
// 保留async+await用法
/* const validatePlaceNum = async(rule, placeNum, callback) => {
  if (placeNum === '') return callback(new Error('请输入产地编号！'));
  const res = await get(`/place/place-num-verify?placeNum=${placeNum}`);
  if(!res.data) return callback(new Error('产地编号已存在！'));
  return true;
} */

// 验证产地编号的唯一性
const validatePlaceNum = (rule, placeNum, callback) => {
  if(placeNum==='') return callback(new Error('请输入产地编号！'));
  get(`/place/place-num-verify?placeNum=${placeNum}`).then(res => {
    if(!res.data){
      callback(new Error('产地编号已存在！'));
    }else{
      callback();
    }
  })
}

// 表单验证规则
const rules = reactive({
  placeName: [
    { required: true, message: '请输入产地名称', trigger: 'blur' }
  ],
  placeNum: [
    { validator: validatePlaceNum, trigger: 'blur' }
  ]
})

// 关闭
const close = () => {
  for(let prop in placeAdd){
    placeAdd[prop] = '';
  }
  
  visible.value = false;
}

// 该对话框打开，进行数据初始化
const open = () => {
  visible.value = true;
};

const placeAddRef = ref();
// 定义
const emit = defineEmits(["ok"]);
// 添加商品提交
const addPlace = () => {
  placeAddRef.value.validate(valid => {
    if(valid){
      post('/place/place-add', placeAdd).then(result => {
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