import math

import streamlit as st


def example_ops(example: str, n: int) -> int:
    if example == "example1":
        return n
    if example == "example2":
        return 2 * n
    if example == "example3":
        return n * n
    if example == "example4":
        return (2 * n) * (2 * n + 1) // 2
    return (n * n) * (n * n + 1) // 2


def non_two_sum(values: list[int]) -> int:
    return 2 * max(values) + 1 if values else 0


st.set_page_config(page_title="Algorithm Analysis Tutor", page_icon="📈", layout="wide")

st.title("📈 Algorithm Analysis Tutor")
st.write(
    "This app teaches the ideas behind COMP254 Lab 2 by turning the Java exercises into visual explanations of growth rates and problem-solving strategies."
)

tab1, tab2, tab3 = st.tabs(["Big-O Explorer", "Uniqueness Timing", "Two-Sum Reasoning"])

with tab1:
    n = st.slider("Choose n", 1, 50, 10)
    example = st.selectbox("Select a Java example", ["example1", "example2", "example3", "example4", "example5"])
    ops = example_ops(example, n)
    big_o = {
        "example1": "O(n)",
        "example2": "O(n)",
        "example3": "O(n²)",
        "example4": "O(n²)",
        "example5": "O(n⁴)",
    }[example]
    st.metric("Estimated loop work", f"{ops:,}")
    st.metric("Big-O class", big_o)
    st.info("The key lesson is that constants disappear in Big-O, but nested loops and powers of n change the growth class dramatically.")

with tab2:
    size = st.slider("Hypothetical array size", 10, 5000, 500, step=10)
    unique1_score = size * size
    unique2_score = int(size * math.log2(size))
    st.metric("unique1 rough cost", f"{unique1_score:,}")
    st.metric("unique2 rough cost", f"{unique2_score:,}")
    st.write("In the original lab, the point was to compare slower and faster uniqueness approaches and see how the runtime grows.")

with tab3:
    raw = st.text_input("Enter integers separated by commas", "3, 10, -2, 7, 4")
    values = [int(piece.strip()) for piece in raw.split(",") if piece.strip()]
    answer = non_two_sum(values)
    st.metric("A value that cannot be formed as a two-sum", answer)
    st.write(
        "The Java solution uses `2 * max + 1`, which is always larger than any possible sum made from two values bounded by the maximum element."
    )
