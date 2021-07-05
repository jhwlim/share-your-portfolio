<template>
    <div class="content">
        <h3 class="post__title pointer" @click="moveToPost()">{{ title }}</h3>
        <p class="post__content">{{ content }}</p>
    </div>
</template>

<script>
export default {
    props: [
        'id',
        'title',
        'content'
    ],
    methods: {
        moveToPost() {
            this.$router.push(`/post/${this.id}`)
        },
    }
}
</script>

<style scoped>
@import '../../assets/css/post/index.css';
.content {
    padding: 16px 0;
    min-height: 180px;
    border-bottom: 1.5px #b6b6b6 solid;
}
</style>