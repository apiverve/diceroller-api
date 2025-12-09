declare module '@apiverve/diceroller' {
  export interface dicerollerOptions {
    api_key: string;
    secure?: boolean;
  }

  export interface dicerollerResponse {
    status: string;
    error: string | null;
    data: DiceRollerData;
    code?: number;
  }


  interface DiceRollerData {
      diceNotation:       string;
      numDice:            number;
      numSides:           number;
      modifier:           number;
      rolls:              number[];
      total:              number;
      totalWithModifier:  number;
      minRoll:            number;
      maxRoll:            number;
      averageRoll:        number;
      theoreticalMin:     number;
      theoreticalMax:     number;
      theoreticalAverage: number;
      expression:         string;
  }

  export default class dicerollerWrapper {
    constructor(options: dicerollerOptions);

    execute(callback: (error: any, data: dicerollerResponse | null) => void): Promise<dicerollerResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: dicerollerResponse | null) => void): Promise<dicerollerResponse>;
    execute(query?: Record<string, any>): Promise<dicerollerResponse>;
  }
}
