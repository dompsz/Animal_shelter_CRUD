<script lang="ts">
	import Button from '$lib/Button.svelte';
	import InputText from '$lib/InputText.svelte';
	import { enhance } from '$app/forms';
	import InputNumber from '$lib/InputNumber.svelte';
	import SelectCell from '$lib/SelectCell.svelte';

	let {data} = $props();
</script>

<h2 class="text-xl font-bold mb-2 my-4">Edytuj Zwierzaka</h2>

<form class="flex gap-4 flex-col" method="POST" use:enhance>
	<InputText name="name" placeholder="Imię" value={data.pet.name}/>
	<SelectCell table={data.species} selected_id={data.pet.species.id} name="species" disabled_message="Wybierz gatunek"/>
	<InputNumber name="active" placeholder="Aktywność" value={data.pet.active}/>
	<InputNumber name="friendly" placeholder="Przyjazność" value={data.pet.friendly}/>
	<InputNumber name="health" placeholder="Wymagania Zdrowotne" value={data.pet.health}/>
	<Button type="submit">Dodaj</Button>
</form>