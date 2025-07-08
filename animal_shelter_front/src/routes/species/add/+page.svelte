<script lang="ts">
	import Button from '$lib/Button.svelte';
	import InputText from '$lib/InputText.svelte';
	import { enhance } from '$app/forms';
</script>

<h2 class="text-xl font-bold mb-2 my-4">Dodaj Gatunek</h2>

<form class="flex gap-4 flex-col" method="POST" use:enhance>
	<InputText name="name" placeholder="Nazwa"/>
	<Button type="submit">Dodaj</Button>
</form>