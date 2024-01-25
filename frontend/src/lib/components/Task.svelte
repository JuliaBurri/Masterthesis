<script lang="ts">

    export let task: { title: string, prio: String, category: string, duration: number, done: boolean }
</script>

<div class="task-wrapper">
    <div class="row">
        <input type="checkbox" checked={task.done}/>
        <h3>{task.title}</h3>
    </div>

    <div>
        <p>{"Priority " + task.prio}</p>
        <p>{task.duration+ " min"}</p>
    </div>
</div>

<style>
    .task-wrapper {
        border: solid 2px #739072;
        display: flex;
        justify-content: space-between;
        align-items: center;
        padding: 12px 24px;
        border-radius: 8px;
        background-color: white;
    }

    .row {
        display: flex;
        align-items: center;
        gap: 12px;
    }

    p{
        font-size: 14px;
        line-height: 14px;
        margin: 0;
        text-align: right;
    }
</style>

