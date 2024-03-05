<script lang="ts">
	import type { Priority } from '$lib/types/Priority';

	export let priorities: Priority[];
</script>

<form action="?/add" method="POST">
	<div class="field">
		<label for="title">Title</label>
		<input type="text" id="title" name="title" required />
	</div>
	<div class="field">
		<label for="description">Description</label>
		<textarea id="description" name="description" required />
	</div>
	<div class="field">
		<label for="duration">Duration</label>
		<input type="number" id="duration" name="duration" step="5" required />
	</div>
	<div class="field">
		<select required name="priority">
			<option value="" disabled selected>Select task priority</option>
			{#each priorities as p}
				<option value={p}>
					{p}
				</option>
			{/each}
		</select>
	</div>
	<button style="margin: 12px 0" type="submit">Add task</button>
</form>

<style>
	form {
		display: flex;
		flex-flow: column wrap;
		gap: 20px;
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

	.field {
		display: flex;
		flex-flow: column nowrap;
		align-items: flex-start;
		gap: 2px;
	}

	select,
	input,
	textarea {
		padding: 8px;
		border-radius: 4px;
		border: none;
	}
</style>
