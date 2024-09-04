import { writable, type Writable } from 'svelte/store';

class Store {
	plotData: Writable<[number, number][]> = writable<[number, number][]>([]);

	subscribe(fn: (data: [number, number][]) => void) {
		return this.plotData.subscribe(fn);
	}

	update(fn: (data: [number, number][]) => [number, number][]) {
		this.plotData.update(fn);
	}

	append(data: [number, number][]) {
		this.plotData.update((d) => [...d, ...data]);
	}

	appendItem(data: [number, number]) {
		this.plotData.update((d) => [...d, data]);
	}
}

export const store = new Store();
