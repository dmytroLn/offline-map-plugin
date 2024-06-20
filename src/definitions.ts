export interface OfflineMapPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
