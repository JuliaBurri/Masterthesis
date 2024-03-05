import { fail } from '@sveltejs/kit';
import type { Actions, PageServerLoad } from './$types';

export const load = (async ({ fetch }) => {
	const fetchTasks = async () => {
		const taskResponse = await fetch('http://localhost:8080/api/tasks');
		return await taskResponse.json();
	};

	const fetchPrios = async () => {
		const taskResponse = await fetch('http://localhost:8080/api/tasks/priorities');
		return await taskResponse.json();
	};

	return {
		tasks: await fetchTasks(),
		priorities: await fetchPrios()
	};
}) satisfies PageServerLoad;

export const actions: Actions = {
	add: async ({ request }) => {
		const data = await request.formData();

		const newTask = {
			title: data.get('title'),
			description: data.get('description'),
			duration: data.get('duration'),
			prio: data.get('priority')
		};

		try {
			const res = await fetch('http://localhost:8080/api/tasks', {
				method: 'POST',
				headers: {
					'Content-Type': 'application/json'
				},
				body: JSON.stringify(newTask)
			});

			console.log(await res.json());
		} catch (err) {
			fail(500, {
				error: 'Creating failed'
			});
		}

		return { success: true };
	}
};
