<script lang="ts">
    import Header from '$lib/components/Header.svelte';
</script>

<div class="app">
    <Header/>
    <main>
        <slot/>
    </main>
</div>

<style>

    :global(body) {
        width: 100%;
        min-height: 100%;
        background-color: #ECE3CE;
        margin: 0;
        font-family: -system-ui, -apple-system, BlinkMacSystemFont, sans-serif;
    }

    :global(main) {
        padding: 0 48px;
    }

</style>
