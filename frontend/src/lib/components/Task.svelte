<script lang="ts">
    import {getDateTime} from "$lib/helper/date-format-helper";

    export let task: { title: string, prio: String, category: string, dueDate: String }
</script>

<div class="task-wrapper">
    <div class="row">
        <input type="checkbox"/>
        <h3>{task.title}</h3>
    </div>

    <div>
        <p>{"Priority " + task.prio}</p>
        <p>{getDateTime(task.dueDate)}</p>
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

