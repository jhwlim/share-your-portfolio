<template>
    <div class="header">
        <div class="header__info">
            <user-image :id="id" class="pointer"></user-image>
            <div class="header__text">
                <span class="header__username pointer">{{ username }}</span>
                <span class="header__date">{{ date }}</span>
            </div>
        </div>
        <div class="header__more">
            <span class="material-icons pointer">more_vert</span>
        </div>
    </div>
</template>

<script>
import UserImage from '@/components/common/UserImage.vue';

export default {
    components: {
        UserImage,
    },
    props: [
        'id',
        'username',
        'date',
    ]
}
</script>

<style scoped>
.header {
    display: flex;
    align-items: center;
    justify-content: space-between;
}
.header__info {
    display: flex;
    align-items: center;
}
.header__text {
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    height: 36px;
}
.header__username {
    font-weight: 400;
}
.header__username:hover {
    color: red;
}
.header__date {
    font-weight: 300;
    font-size: 14px;
}
.header__more span {
    font-size: 26px;
}
.header__more span:hover {
    color: red;
}
</style>