<script lang="ts">

	export let table: any;
	export let disabled_message: string;
	export let name;
	export let selected_id: number | undefined = undefined;
</script>

<div>
	<select class="text-gray-600 border-b-black border-2 p-3 font-bold w-60" name={name} required>
		{#if !selected_id}
			<option disabled selected>
				{disabled_message}
			</option>
		{/if}
		{#each table as piece}
			<option value={piece.id} selected={selected_id === piece.id}>
				{piece.name}
			</option>
		{/each}
	</select>
</div>