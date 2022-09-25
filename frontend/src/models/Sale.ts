export type Sale = {
    id: number;
    seller: {
        id: number,
        name: string
    };
    date: string;
    visited: number;
    deals: number;
    amount: number;
}