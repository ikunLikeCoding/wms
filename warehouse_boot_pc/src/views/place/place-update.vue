<template>
  <!-- 修改产地对话框 -->
  <el-dialog v-model="visible" title="修改产地" width="400px" @close="close" destroy-on-close>
    <el-form ref="placeUpdateRef" :model="placeUpdate" :rules="rules" label-position="right" label-width="100px">
      <el-form-item label="产地编号：" prop="placeNum">
        <el-input v-model="placeUpdate.placeNum" disabled />
      </el-form-item>
      <el-form-item label="产地名称：" prop="placeName">
        <el-input v-model="placeUpdate.placeName" />
      </el-form-item>
      <el-form-item label="产地描述：" prop="introduce">
        <el-input v-model="placeUpdate.introduce" />
      </el-form-item>
    </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="close">取消</el-button>
        <el-button type="primary" @click="updatePlace">确定</el-button>
      </span>
    </template>
  </el-dialog>
</template>

<script setup>
import { ref, reactive } from 'vue'
import { put, tip } from "@/common"
import { Plus } from '@element-plus/icons-vue'

// 该页面的可见性
const visible = ref(false);


// 修改产地对象
const placeUpdate = reactive({
  placeName: '',
  placeNum: '',
  introduce: '',
});

// 表单验证规则
const rules = reactive({
  placeName: [
    { required: true, message: '请输入产地名称', trigger: 'blur' }
  ]
})

// 关闭
const close = () => {
  visible.value = false;
}

// 该对话框打开，进行数据初始化
const open = (place) => {
  visible.value = true;

  for(let prop in place){
    placeUpdate[prop] = place[prop];
  }
};

const placeUpdateRef = ref();
// 定义
const emit = defineEmits(["ok"]);
// 添加产地提交
const updatePlace = () => {
  placeUpdateRef.value.validate(valid => {
    if(valid){
      put('/place/place-update', placeUpdate).then(result => {
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