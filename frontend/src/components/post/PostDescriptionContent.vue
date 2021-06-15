<template>
    <div class="content">
        <h1 class="pointer">{{ title }}</h1>
        <p>{{ content }}</p>
    </div>
</template>

<script>
export default {
    props: [
        'title',
        'content'
    ],
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