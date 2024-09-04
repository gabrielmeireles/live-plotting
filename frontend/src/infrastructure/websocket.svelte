<script lang="ts">
    import { Client } from '@stomp/stompjs';
    import { onMount } from 'svelte';
	import { store } from '../store/Store.svelte';

    const onMessage = (event: any) => {
        const { timestamp, value } = JSON.parse(event.body);
        const data: [number, number]  = [timestamp, value];
        store.appendItem(data);
    }

    onMount(() => {
            
        const client = new Client({
                brokerURL: 'ws://localhost:8080/ws',
                onConnect: () => {
                    client.subscribe('/topic', onMessage);
                },
            },
        );
        
        client.activate(); 
    });

</script>