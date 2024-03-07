import type {PageLoad} from './$types';
import type {Task} from "$lib/types/Task";

export const load = (async ({fetch}) => {
    const fetchTasks = async (): Promise<Task[]> => {
        const taskResponse = await fetch('http://localhost:8080/api/tasks');
        return await taskResponse.json()
    };

    const fetchPrios = async () => {
        const taskResponse = await fetch('http://localhost:8080/api/tasks/priorities');
        return await taskResponse.json();
    };


    return {
        tasks: await fetchTasks(),
        priorities: await fetchPrios()
    };
}) satisfies PageLoad;
