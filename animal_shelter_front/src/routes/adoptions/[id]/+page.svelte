<script lang="ts">
	import Button from '$lib/Button.svelte';
	import InputText from '$lib/InputText.svelte';
	import { enhance } from '$app/forms';
	import InputNumber from '$lib/InputNumber.svelte';
	import SelectCell from '$lib/SelectCell.svelte';

	let {data} = $props();
</script>

<h2 class="text-2xl font-bold mb-4 my-4">Formularz Adopcyjny</h2>

<form class="flex gap-4 flex-col" method="POST" use:enhance>

	<h2 class="text-xl font-bold mb-2 my-4">Wybrany Zwierzak:</h2>

	<div><h3 class="text-base font-bold mb-1 my-1">Imię: {data.pet.name} ({data.pet.species.name})</h3></div>
	<div><h3 class="text-base font-bold mb-1 my-1">Aktywność: {data.pet.active}</h3></div>
	<div><h3 class="text-base font-bold mb-1 my-1">Przyjazność: {data.pet.friendly}</h3></div>
	<div><h3 class="text-base font-bold mb-1 my-1">Wymagania Zdrowotne: {data.pet.health}</h3></div>

	<input type="hidden" name="id" value={data.pet.id}/>
	<input type="hidden" name="name" value={data.pet.name}/>
	<input type="hidden" name="species" value={data.pet.species.name}/>
	<input type="hidden" name="active" value={data.pet.active}/>
	<input type="hidden" name="friendly" value={data.pet.friendly}/>
	<input type="hidden" name="health" value={data.pet.health}/>

	<h2 class="text-xl font-bold mb-2 my-6">Twoje Dane Kontaktowe</h2>

	<InputText name="fname" placeholder="Imię" />
	<InputText name="lname" placeholder="Nazwisko" />
	<InputNumber name="number" placeholder="Nr. Telefonu" />
	<InputText name="email" placeholder="Email" />
	<Button type="submit">Wyślij Formularz Adopcyjny</Button>
</form>