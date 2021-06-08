<template>
    <div class="wrapper">
        <div class="container">
            <router-link to="/" class="header pointer">LOGO</router-link>
            <form class="login-form">
                <div class="login-form__input-box">
                    <label for="username">아이디</label>
                    <input type="text" id="username" autocomplete="off">
                </div>
                <div class="login-form__input-box">
                    <label for="password">패스워드</label>
                    <input type="password" id="password" autocomplete="new-password">
                </div>
                <div class="login-form__btn pointer">로그인</div>
            </form>
            <div class="social-login">
                <div class="social-login__icon pointer">
                    <img src="@/assets/image/naver-icon.png" alt="">
                </div>
                <div class="social-login__icon pointer">
                    <img src="@/assets/image/kakaotalk-icon.png" alt="">
                </div>
                <div class="social-login__icon social-login__icon--small pointer">
                    <img src="@/assets/image/google-icon.png" alt="">
                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    data: function() {
        return {
            
        };
    },
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Ubuntu:wght@700&display=swap');

.wrapper {
    height: 100vh;
    background-color: #f5f5f5;
    display: flex;
    align-items: center;
    justify-content: center;
}
.header {
    display: block;
    font-family: 'Ubuntu', sans-serif;
    font-size: 56px;
    margin: 10px 0 20px;
    text-align: center;
}
.login-form__input-box {
    margin-bottom: 20px;
}
.login-form__input-box label {
    display: block;
    margin-bottom: 6px;
}
.login-form__input-box input {
    width: 260px;
    padding: 6px;
    border: 0;
    border-bottom: 1px solid #dbdbdb;
    font-family: 'Noto Sans KR', sans-serif;;
}
.login-form__input-box input:focus {
    outline: 0;
    border-bottom-color: red;
}
.login-form__btn {
    width: 100%;
    padding: 10px 0;
    text-align: center;
    background-color: lightgray;
}
.social-login {
    padding: 20px;
    display: flex;
    align-items: center;
    justify-content: space-evenly;
}
.social-login__icon {
    display: inline-block;
    width: 36px;
    text-align: center;
}
.social-login__icon img {
    width: 100%;
    object-fit: contain;
}
.social-login__icon--small img {
    width: 80%;
}
</style>