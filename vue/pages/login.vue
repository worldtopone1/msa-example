<template>
  <div class="login-container">
    <el-form status-icon class="login-form">
      <h3 class="title">로그인</h3>
      <el-form-item prop="username">
        <el-input
          ref="username"
          v-model="loginForm.username"
          placeholder="Username"
          name="username"
          type="text"
        />
      </el-form-item>
      <el-form-item prop="username">
        <el-input
          v-model="loginForm.passwqord"
          placeholder="Password"
          name="password"
          type="text"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" style="width:100%;margin-bottom:30px;" >로그인</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  name: 'Login',
  layout: 'single',
  data() {
    return {
      loginForm: {
        username: '',
        password: ''
      }
    }
  }
}
</script>

<style>
.login-container {
  position: relative;
  width: 100%;
  height: 100%;
}
.login-form {
  position:relative;
  top:0; left:0; bottom:0; right:0;
  margin:10% auto;
  width:400px;
  height:500px;
}

.title {
  color: #ffffff;
  text-align: center;
  padding: 10px;
}
</style>