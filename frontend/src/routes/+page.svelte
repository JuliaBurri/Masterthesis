<script lang="ts">
	import AddTaskForm from '$lib/components/AddTaskForm.svelte';
	import Task from '$lib/components/Task.svelte';

	export let data;

	$: tasks = data.tasks;
	$: priorities = data.priorities;

	async function schedule() {
		// TODO: User Story 3 - Call api to get schedule
		console.log('Schedule Work Day');
	}
</script>

<button on:click={schedule}>Schedule Work Day</button>
<div class="container">
	<div class="list">
		<h1>Todays Tasks</h1>
		{#each tasks as task}
			<Task {task} />
		{/each}

		<h1>Tomorrows Tasks</h1>
		<p>Hint: Tasks that don't fit inside todays schedule should be displayed here.</p>
	</div>
	<div class="add-task-container">
		<h1>Add a new Task</h1>
		<!-- TODO: User Story 1 - Add input fields for title, description, duration -->
		<AddTaskForm {priorities} />
	</div>
</div>

<style>
	.container {
		display: grid;
		/* TODO: User Story 1 - this grid should be responsive */
		grid-template-columns: repeat(auto-fit, minmax(450px, 1fr));
		gap: 24px;
	}

	.list {
		display: flex;
		flex-direction: column;
		gap: 12px;
		padding: 24px;
		margin: 24px 0;
		border-radius: 8px;
		overflow-y: scroll;
		background-color: #3a4d39;
	}

	.add-task-container {
		background-color: #739072;
		padding: 24px;
		margin: 24px 0;
		border-radius: 8px;
		display: flex;
		flex-direction: column;
		gap: 12px;
	}

	button {
		background-color: whitesmoke;
		border: solid 1px #3a4d39;
		border-radius: 4px;
		padding: 8px;
		color: #739072;
		font-size: 14px;
		cursor: pointer;
		text-transform: uppercase;
	}

	h1 {
		width: 100%;
		color: whitesmoke;
	}

	p {
		color: whitesmoke;
		margin: 0;
		font-size: 12px;
	}
</style>
