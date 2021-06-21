<template>
    <div class="header-nav">
        <router-link to="/" class="header-nav__name">LOGO</router-link>
        <div class="header-nav__links">
            <div v-if="isLogined"  class="header-nav__link">
                <span @click="changeDropboxState()" class="material-icons header-nav__icon pointer" :class="clickedIconStyle">account_circle</span>
                <ul v-if="showDropbox" class="header-nav__drop-box shadow">
                    <li class="pointer">계정 관리</li>
                    <li class="pointer">채팅</li>
                    <li class="pointer" @click="logout()">로그아웃</li>
                </ul>
            </div>
            <div v-else class="header-nav__link">
                <router-link to="/login" class="header-nav__icon-text pointer">로그인</router-link>
                <span class="header-nav__icon-text pointer">회원가입</span>
            </div>
        </div>        
    </div>
</template>

<script>
import { mapGetters, mapActions } from 'vuex';

export default {
    name: 'HeaderNav',
    data: function() {
        return  {
            showDropbox: false,
        };
    },
    computed: {
        ...mapGetters(['isLogined']),
        clickedIconStyle() {
            return this.showDropbox ? 'header-nav__icon--clicked' : null;
        },
    },
    methods: {
        ...mapActions(['user', 'logout']),
        changeDropboxState() {
            this.showDropbox = !this.showDropbox;
        },
    }
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Ubuntu:wght@700&display=swap');

.header-nav {
    padding: 18px 40px;
    display: flex;
    align-items: center;
    justify-content: space-between;
    background-color: #f5f5f5;
}
.header-nav__name {
    font-family: 'Ubuntu', sans-serif;
    font-size: 46px;
}
.header-nav__link {
    display: flex;
    align-items: center;
    position: relative;
}
.header-nav__icon-text:hover {
    color: gray;
}
.header-nav__icon {
    font-size: 42px;
}
.header-nav__icon--clicked {
    color: #f5f5f5;
    background-color: black;
    border-radius: 50%;
}
.header-nav__icon-text {
    font-size: 20px;
    font-weight: 300;
    letter-spacing: 1px;
    margin-left: 8px;
}
.header-nav__drop-box {
    position: absolute;
    top: 46px;
    right: 0;
    border: 1px solid gray;
    border-radius: 5px;
    padding: 6px 0;
    width: 140px;
    text-align: center;
    background-color: white;
}
.header-nav__drop-box li {
    padding: 10px 0;
    border-bottom: 1px solid #dadada;
}
.header-nav__drop-box li:last-child {
    border-bottom: 0;
}
</style>