# offline-map

Mapbox plugin with offline support

## Install

```bash
npm install offline-map
npx cap sync
```

## API

<docgen-index>

* [`showMap(...)`](#showmap)
* [`initialize(...)`](#initialize)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### showMap(...)

```typescript
showMap(options: { container: string; style: string; center: [number, number]; zoom: number; }) => Promise<void>
```

| Param         | Type                                                                                       |
| ------------- | ------------------------------------------------------------------------------------------ |
| **`options`** | <code>{ container: string; style: string; center: [number, number]; zoom: number; }</code> |

--------------------


### initialize(...)

```typescript
initialize(options: { accessToken: string; }) => Promise<void>
```

| Param         | Type                                  |
| ------------- | ------------------------------------- |
| **`options`** | <code>{ accessToken: string; }</code> |

--------------------

</docgen-api>
