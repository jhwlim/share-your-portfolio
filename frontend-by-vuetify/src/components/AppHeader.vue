<template>
    <v-app-bar
        app
        color="white"
        class="px-4 py-1"
        height="70"
    >
        <v-container class="d-flex justify-space-between align-center">
            <logo-image
                :width="150"
            ></logo-image>
            <v-spacer></v-spacer>
            <router-link to="/login">
                <v-btn
                    text
                >로그인</v-btn>
            </router-link>
            <router-link to="/signup">
                <v-btn
                    text
                >회원가입</v-btn>
            </router-link>
        </v-container>
    </v-app-bar>
</template>

<script>
import LogoImage from '@/components/LogoImage.vue';

export default {
    name: 'AppHeader',
    components: {
        LogoImage,
    },
}
</script>
