<script lang="ts">
	import Button from '$lib/Button.svelte';
	import InputText from '$lib/InputText.svelte';
	import { enhance } from '$app/forms';
	import SelectCell from '$lib/SelectCell.svelte';
	import InputNumber from '$lib/InputNumber.svelte';

	let {data} = $props();
</script>

<h2 class="text-xl font-bold mb-2 my-4">Dodaj Zwierzaka</h2>

<form class="flex gap-4 flex-col" method="POST" use:enhance>
	<InputText name="name" placeholder="Imię"/>
	<SelectCell table={data.species} name="species" disabled_message="Wybierz gatunek"/>
	<InputNumber name="active" placeholder="Aktywność" />
	<InputNumber name="friendly" placeholder="Przyjazność" />
	<InputNumber name="health" placeholder="Wymagania Zdrowotne" />
	<Button type="submit">Dodaj</Button>
</form>