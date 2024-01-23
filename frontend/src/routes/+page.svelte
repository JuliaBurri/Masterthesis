<script lang="ts">
    import Task from "$lib/components/Task.svelte";

    export let data;
    $: tasks = data.tasks

</script>

<div>
    Add Filter Functionality
</div>
<div class="container">
    <div class="list">
        <h1>Tasks</h1>
        {#each tasks as task}
            <Task {task}/>
        {/each}
    </div>
    <div class="add-task-container">
        <h1>Add a new Task</h1>
        TODO: Neue Aufgabe erstellen (Title, Description, DueDate, Prio, Category)
    </div>
</div>

<style>
    .container {
        display: grid;
        grid-template-columns: 2fr 1fr;
        gap: 24px;
    }

    .list {
        display: flex;
        flex-direction: column;
        gap: 12px;
        padding: 24px;
        margin: 24px 0;
        border-radius: 8px;
        min-height: 540px;
        background-color: #3A4D39;
    }

    .add-task-container {
        background-color: #739072;
        padding: 24px;
        margin: 24px 0;
        border-radius: 8px;
        min-height: 540px;
    }

    h1 {
        width: 100%;
        color: whitesmoke;
    }
</style>
