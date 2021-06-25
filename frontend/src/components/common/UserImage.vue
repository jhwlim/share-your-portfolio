<template>
    <div class="user-image">
        <img v-if="isLoading" src="@/assets/image/loading.gif">
        <img v-else-if="!isError" :src="imgSrc" alt="??" @error="imageError()">
        <img src="@/assets/image/no-account-image.png">
    </div>
</template>

<script>
export default {
    data: function() {
        return {
            isError: false,
        };
    },
    props: ['id', 'isLoading'],
    computed: {
        imgSrc() {
            return `/account/image/${this.id}`;
        },
    },
    methods: {
        imageError() {
            this.isError = true;
        },
    }
}
</script>

<style scoped>
.user-image {
    width: 46px;
    height: 46px;
    display: inline-block;
    overflow: hidden;
    margin-right: 6px;
}
.user-image img {
    width: 100%;
    height: 100%;
    object-fit: contain;
}
</style>