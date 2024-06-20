import { WebPlugin } from '@capacitor/core';
import mapboxgl from 'mapbox-gl';

import type { OfflineMapPlugin } from './definitions';

export class OfflineMapWeb extends WebPlugin implements OfflineMapPlugin {
  private map: mapboxgl.Map | null = null;

  async initialize(options: { accessToken: string }): Promise<void> {
    mapboxgl.accessToken = options.accessToken;
  }

  async showMap(options: {
    container: string;
    style: string;
    center: [number, number];
    zoom: number;
  }): Promise<void> {
    this.map = new mapboxgl.Map({
      container: options.container,
      style: options.style,
      center: options.center,
      zoom: options.zoom,
    });

    this.map.addControl(new mapboxgl.NavigationControl());
  }
}
