<template>
    <div id="naverIdLogin"></div>
</template>

<script>
/* eslint-disable */

const naverLogin = new window.naver.LoginWithNaverId({
    clientId: process.env.VUE_APP_NAVER_CLIENTID,
    callbackUrl: 'http://localhost:8080/api/login/naver',
    isPopup: true,
    loginButton:{
        color: 'green',
        type: 3,
        height: 48,
    },
});
export default {
    mounted: function() {
        naverLogin.init();
    }
}
</script>

<style>

</style>