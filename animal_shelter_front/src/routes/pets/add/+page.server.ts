import { redirect } from '@sveltejs/kit';
import {BACKEND} from '$env/static/private';
import type { Species } from '$lib/types';

export const load = async () => {
	const REQ_SPECIES = await fetch(BACKEND+"/species");

	const SPECIES: Array<Species> = await REQ_SPECIES.json();

	return {species: SPECIES}
}

export const actions = {
	default: async ({ request }) => {
		const DATA = await request.formData();

		const NAME = DATA.get("name");
		const SPECIES = DATA.get("species");
		const ACTIVE = DATA.get("active");
		const FRIENDLY = DATA.get("friendly");
		const HEALTH = DATA.get("health");


		if (NAME && SPECIES && ACTIVE && FRIENDLY && HEALTH) {
			await fetch(BACKEND+"/pets", {
				method: "POST",
				headers: {
					"Content-Type": "application/json",
				},
				body: JSON.stringify({
					name: NAME,
					species: {
						id: SPECIES,
					},
					active: ACTIVE,
					friendly: FRIENDLY,
					health: HEALTH,
				})
			})

			return redirect(303, "/pets");
		}
	}
};