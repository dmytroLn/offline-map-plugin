export interface OfflineMapPlugin {
  showMap(options: {
    latitude: number;
    longitude: number;
    zoom: number;
  }): Promise<void>;
  initialize(options: { accessToken: string }): Promise<void>;
}
