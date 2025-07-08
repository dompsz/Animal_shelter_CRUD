import { BACKEND } from '$env/static/private';
import type { Pet } from '$lib/types';
import { redirect } from '@sveltejs/kit';

export const load = async ({ params }) => {
	const REQ_PET = await fetch(BACKEND+`/pets/${params.id}`);

	const PET: Pet = await REQ_PET.json();

	return {
		pet: PET,
	}
}

export const actions = {
	default: async ({ request }) => {
		const DATA = await request.formData();

		const NAME = DATA.get("name");
		const SPECIES = DATA.get("species");
		const ACTIVE = DATA.get("active");
		const FRIENDLY = DATA.get("friendly");
		const HEALTH = DATA.get("health");
		const FNAME = DATA.get("fname");
		const LNAME = DATA.get("lname");
		const NUMBER = DATA.get("number");
		const EMAIL = DATA.get("email");


		console.log(`
			--- WYSYŁAMY MAILA ---
			Do: adopcje@schronisko.pl
			Tytuł: Formularz adopcyjny - ${NAME}
			Treść:
				Zwierzak: ${NAME} (${SPECIES})
				Aktywność: ${ACTIVE}
				Przyjazność: ${FRIENDLY}
				Zdrowie: ${HEALTH}
				
				Imię: ${FNAME}
				Nazwisko: ${LNAME}
				Tel: ${NUMBER}
				Email: ${EMAIL}
		`)

		return redirect(303, "/dziekujemy");
	}
};