<template>
    <div>
        callback
    </div>
</template>

<script>
import { mapActions } from 'vuex';
import router from '@/router';

const naverLogin = new window.naver.LoginWithNaverId({
    clientId: process.env.VUE_APP_NAVER_CLIENTID,
    callbackUrl: 'http://localhost:8080/login/naver',
    isPopup: false,
    callbackHandle: true,
});

export default {
    methods: {
        ...mapActions(['user', 'socialLogin']),
    },
    mounted: function() {
        naverLogin.init();
        naverLogin.getLoginStatus((status) => {
                if (status) {
                    const email = naverLogin.user.email;
                    const name = naverLogin.user.name;
                    
                    this.socialLogin({email, name});
                    router.replace('/');
                }
            });
        window.addEventListener('load', function() {
            
        })
    }
}
</script>

<style>

</style>