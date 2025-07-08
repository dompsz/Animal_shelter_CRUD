import { BACKEND } from '$env/static/private';
import type { Species } from '$lib/types';
import { redirect } from '@sveltejs/kit';

export const load = async ({ params }) => {
	const REQUEST = await fetch(BACKEND+`/species/${params.id}`);

	const SPECIE: Species = await REQUEST.json();

	return {
		species: SPECIE
	}
}

export const actions = {
	default: async ({ request, params }) => {
		const DATA = await request.formData();

		const NAME = DATA.get("name");

		if (NAME) {
			await fetch(BACKEND+"/species", {
				method: "POST",
				headers: {
					"Content-Type": "application/json",
				},
				body: JSON.stringify({
					id: params.id,
					name: NAME,
				})
			})

			return redirect(303, "/species");
		}
	}
};