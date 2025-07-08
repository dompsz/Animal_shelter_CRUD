import { redirect } from '@sveltejs/kit';
import {BACKEND} from '$env/static/private';

export const actions = {
	default: async ({ request }) => {
		const DATA = await request.formData();

		const NAME = DATA.get("name");

		if (NAME) {
			await fetch(BACKEND+"/species", {
				method: "POST",
				headers: {
					"Content-Type": "application/json",
				},
				body: JSON.stringify({
					name: NAME,
				})
			})

			return redirect(303, "/species");
		}
	}
};