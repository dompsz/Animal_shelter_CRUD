<script lang="ts">
	export let name: string;
	export let placeholder: string = "";
	export let value: number | undefined = undefined;
</script>

<div>
	<input class="text-gray-600 border-b-black border-2 p-3 font-bold" type="number"
				 name={name} id={name} placeholder={placeholder} required bind:value={value}/>
</div>