import type { Pet } from '$lib/types';
import {BACKEND} from '$env/static/private';

export const load = async () => {

	const REQUEST = await fetch(BACKEND+"/pets");

	const DATA: Array<Pet> = await REQUEST.json();

	return {
		pets: DATA,
	}
}

export const actions = {
	default: async ({ request }) => {
		const DATA = await request.formData();
		const ID = DATA.get("id");

		if(ID) {
			await fetch(BACKEND+"/pets/"+ID, {
				method: "DELETE"
			});
		}
	}
}