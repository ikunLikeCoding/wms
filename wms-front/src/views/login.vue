<template>
  <div class="login" >
    <el-card class="box-card" shadow="always">
      <div
        style="
          padding: 40px 0px 60px 0px;
          text-align: center;
          color: #409eff;
          font-size: 50px;
          font-weight: bold;
          letter-spacing: 3px;
        "
      >IKUN仓库管理系统
      </div>
      <el-form
        ref="loginForm"
        :model="loginUser"
        :rules="rules"
        size="large"
        label-position="right"
        label-width="70px"
        style="width: 360px; margin: 0px auto"
      >
        <el-form-item label="账号" prop="userCode">
          <el-input v-model="loginUser.userCode"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="userPwd">
          <el-input type="password" v-model="loginUser.userPwd" show-password></el-input>
        </el-form-item>
        <el-form-item label="验证码" prop="verificationCode">
          <el-input v-model="loginUser.verificationCode">
            <template #suffix>
              <el-image
                style="overflow: visible; position: relative; left: 16px;"
                :src="codeSrc"
                @click="getCode"
                ></el-image>
            </template>
          </el-input>
        </el-form-item>
      </el-form>
      <div style="text-align: right; width: 360px; margin: 40px auto 0px">
        <el-button
          @click="login"
          type="primary"
          size="large"
          style="width: 300px"
          >登录</el-button>
      </div>
    </el-card>
  </div>


</template>

<script setup>
import { reactive, ref } from "vue";
import { useRouter } from "vue-router";
import { get, post, tip, setLocalToken, API_BASE_URL} from "@/common";
import axios from "axios";

const loginForm = ref(); // 登录表单

const router = useRouter(); // 获取路由器

const loginUser = reactive({
  userCode: "",
  userPwd: "",
  verificationCode: "",
  verificationKey: ''
});

// 验证码后台接口
// const codeSrc = ref(API_BASE_URL + "/captcha/captchaImage");
const codeSrc = ref(); // 验证码图片url
// 获取验证码
const getCode = () => {
  get('/captcha/captchaImage').then(res => {
    // 图片的src属性显示为：前缀+后台传递的Base64验证码图片编码
    // 验证码可以正常显示
    console.log(res)
    codeSrc.value = res.data.img;
    loginUser.verificationKey = res.data.imgKey; // redis存储验证码的key
  })
}

getCode();

const rules = reactive({
  userCode: [
    {
      required: true,
      message: "请输入账号！",
      trigger: "blur"
    },
  ],
  userPwd: [
    {
      required: true,
      message: "请输入密码！",
      trigger: "blur"
    },
  ],
  verificationCode: [
    {
      min: 4,
      max: 4,
      required: true,
      message: "请输入正确的验证码！",
      trigger: "blur"
    }
  ]
});

// 回车登录
window.onkeydown = ($event) => {
  if($event.key && $event.key == 'Enter'){
    login();
  }
}

const login = () => {
  loginForm.value.validate((valid) => {
    if (valid) {
      // 向服务端发出post请求
      let user = new FormData();
      user.append("userCode", loginUser.userCode);
      user.append("userPwd", loginUser.userPwd);
      post("/user/login", user).then(result => {
        // 从回送结果中取出令牌，并将令牌存于客户端
        setLocalToken(result.data);
        tip.success("登录成功！");
        // 通过路由导航到home页面
        router.push({ path: "/home" });
      });
    }
  });
};
//   background-image: url("/login.jpg");
</script>


<style scoped>
.login {

  background-size: 100% 100%;
  background-image: linear-gradient(to right, #fbc2eb, #a6c1ee);
  position: fixed;
  top: 0px;
  bottom: 0px;
  left: 0px;
  right: 0px;

  display: flex;
  justify-content: center;
  align-items: center;
}
.box-card {
  width: 800px;
  height: 500px;
  opacity: 0.92;
}
</style>
