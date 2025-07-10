import type { Pet } from '$lib/types';
import {BACKEND} from '$env/static/private';

export const load = async ({ url }) => {
	const idealActive = url.searchParams.get('idealActive');
	const idealFriendly = url.searchParams.get('idealFriendly');
	const idealHealth = url.searchParams.get('idealHealth');

	let endpoint = "/pets/adoptions"; // default score sort

	// match sort
	if (idealActive && idealFriendly && idealHealth) {
		endpoint = `/pets/match?idealActive=${idealActive}&idealFriendly=${idealFriendly}&idealHealth=${idealHealth}`;
	}

	const REQUEST = await fetch(BACKEND + endpoint);
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