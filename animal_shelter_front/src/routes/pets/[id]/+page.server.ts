import { BACKEND } from '$env/static/private';
import type { Pet, Species } from '$lib/types';
import { redirect } from '@sveltejs/kit';

export const load = async ({ params }) => {
	const REQ_SPECIES = await fetch(BACKEND+"/species");
	const REQ_PET = await fetch(BACKEND+`/pets/${params.id}`);

	const SPECIES: Array<Species> = await REQ_SPECIES.json();
	const PET: Pet = await REQ_PET.json();

	return {
		pet: PET,
		species: SPECIES
	}
}

export const actions = {
	default: async ({ request, params }) => {
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
					id: params.id,
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