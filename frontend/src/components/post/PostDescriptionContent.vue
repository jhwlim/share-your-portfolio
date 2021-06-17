<template>
    <div class="content">
        <h1 class="pointer" @click="moveToPost()">{{ title }}</h1>
        <p>{{ content }}</p>
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
.content {
    padding: 16px 0;
    min-height: 180px;
    border-bottom: 1.5px #b6b6b6 solid;
}
.content h1 {
    font-size: 28px;
    font-weight: 700;
    line-height: 36px;
}
.content p {
    padding: 12px 0;
    line-height: 24px;
}
</style>