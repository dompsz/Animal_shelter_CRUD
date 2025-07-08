<script lang="ts">
	import type {Species} from '$lib/types';
	import LinkButton from '$lib/LinkButton.svelte';
	import Button from '$lib/Button.svelte';
	import { enhance } from '$app/forms';

	export let species: Species;
</script>

<li class="p-3 bg-blue-400 text-white shadow-lg">
	<ul class="justify-between flex flex-wrap">
		<li class="flex gap-5 flex-nowrap">
			<div class="min-w-15">ID: {species.id}</div>
			<div class="min-w-45">Gatunek: {species.name}</div>
		</li>
		<li>
			<div class="flex gap-5 flex-nowrap">
				<LinkButton href="/species/{species.id}">Edytuj</LinkButton>
				<form method="POST" class="flex items-center justify-center" use:enhance>
					<input type="hidden" name="id" value={species.id}/>
					<Button>Usuń</Button>
				</form>
			</div>
		</li>
	</ul>
</li>
