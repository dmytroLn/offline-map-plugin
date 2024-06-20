export interface OfflineMapPlugin {
  showMap(options: {
    container: string;
    style: string;
    center: [number, number];
    zoom: number;
  }): Promise<void>;
  initialize(options: { accessToken: string }): Promise<void>;
}
