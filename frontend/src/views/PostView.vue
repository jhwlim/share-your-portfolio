<template>
    <div>
        post {{ this.$route.params.id }}
    </div>
</template>

<script>
export default {
    data: function() {
        return {
            id: null,
        };
    },
    watch: {
        '$route': 'fetchData',
    },
    methods: {
        fetchData() {
            this.id = this.$route.params.id;
            console.log(this.id);
        },
    },
    created: function() {
        this.fetchData();
    },
}
</script>

<style>

</style>